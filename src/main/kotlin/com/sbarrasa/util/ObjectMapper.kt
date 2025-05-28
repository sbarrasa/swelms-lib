package com.sbarrasa.util

import kotlin.reflect.KClass
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.KProperty1
import kotlin.reflect.full.*


open class ObjectMapper<S:Any, T:Any>(initBlock: ObjectMapper<S, T>.() -> Unit = {}) {

    private val mappings = mutableListOf<Pair<(S) -> Any?, KMutableProperty1<T, Any?>>>()

    var ignoreSourceNulls = true
    init {
        this.apply(initBlock)
    }


    fun <V> bind(sourceProp: KProperty1<S, V>, targetProp: KMutableProperty1<T, V>) {
        bind({sourceProp.get(it)}, targetProp)
    }

    @Suppress("UNCHECKED_CAST")
    fun <SVAL, TVAL> bind(getter: (S) -> SVAL, targetProp: KMutableProperty1<T, TVAL>) {
        mappings.add(getter as (S) -> Any? to targetProp as KMutableProperty1<T, Any?>)
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
                bind(sourceProp, targetProp)
            }
        }


    }
    open fun map(source: S, target: T): T {
        for ((getter, targetProp) in mappings) {
            val value = getter(source)
            if(!ignoreSourceNulls or (value != null))
                targetProp.set(target, value)
        }
        return target
    }

    companion object {
        fun <U : Any> bindAll(uniqueClass: KClass<U>): ObjectMapper<U, U> {
            return ObjectMapper {
                bindAll(uniqueClass, uniqueClass)
            }
        }
    }
}