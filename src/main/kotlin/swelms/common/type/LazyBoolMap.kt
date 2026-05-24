package swelms.common.type

open class LazyBoolMap<out T>(
   private val trueBlock: () -> T,
   private val falseBlock: () -> T
) : BoolMap<T> {
   override val trueValue: T by lazy { trueBlock() }
   override val falseValue: T by lazy { falseBlock() }

   override operator fun not() = LazyBoolMap(falseBlock, trueBlock)
}

infix fun <T> (() -> T).orElse(falseBlock: () -> T): BoolMap<T> =
   LazyBoolMap(this, falseBlock)


