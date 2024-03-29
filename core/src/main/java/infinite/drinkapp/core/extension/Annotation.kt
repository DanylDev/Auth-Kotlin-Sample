package infinite.drinkapp.core.extension

fun <A : Annotation> Class<*>.getAnnotationOrNull(annotationClass: Class<A>): A? = try {
    getAnnotation(annotationClass)
} catch (e: Exception) {
    null
}