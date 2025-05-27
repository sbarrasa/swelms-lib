package com.sbarrasa.util

import kotlin.reflect.KClass
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.KProperty1
import kotlin.reflect.full.*


open class ObjectMapper<S:Any, T:Any>(initBlock: ObjectMapper<S, T>.() -> Unit = {}) {

    private val mappings = mutableListOf<Pair<KProperty1<S, Any?>, KMutableProperty1<T, Any?>>>()

    var ignoreSourceNulls = true
    init {
        this.apply(initBlock)
    }


    @Suppress("UNCHECKED_CAST")
    fun <V> bind(pair: Pair<KProperty1<S, V>, KMutableProperty1<T, V>>) {
        mappings.add(pair as Pair<KProperty1<S, Any?>, KMutableProperty1<T, Any?>>)
    }
    fun bindAll(sourceClass: KClass<S>, targetClass: KClass<T>) {
        val sourceProps = sourceClass.memberProperties.associateBy { it.name }

        val targetProps = targetClass.memberProperties
            .filterIsInstance<KMutableProperty1<T, Any?>>()
            .associateBy { it.name }

        for ((name, sourceProp) in sourceProps) {
            val targetProp = targetProps[name] ?: continue

            if (sourceProp.returnType.withNullability(false)
                == targetProp.returnType.withNullability(false)) {
                bind(sourceProp to targetProp)
            }
        }
    }
    fun map(source: S, target: T): T {
        for ((sourceProp, targetProp) in mappings) {
            val value = sourceProp.get(source)
            if(!ignoreSourceNulls or (value != null))
                targetProp.set(target, value)
        }
        return target
    }

    companion object {
        fun <U : Any> bindAll(cls: KClass<U>): ObjectMapper<U, U> {
            return ObjectMapper {
                bindAll(cls, cls)
            }
        }
    }
}