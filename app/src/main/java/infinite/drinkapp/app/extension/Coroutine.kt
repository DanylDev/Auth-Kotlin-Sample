package infinite.drinkapp.app.extension

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

/**
 * Equivalent to [launch] but return [Unit] instead of [Job].
 *
 * Mainly for usage when you want to lift [launch] to return. Example:
 *
 * ```
 * override fun loadData() = launchSilent {
 *     // code
 * }
 * ```
 */
fun launchSilent(
        context: CoroutineContext = Dispatchers.Default,
        start: CoroutineStart = CoroutineStart.DEFAULT,
        block: suspend CoroutineScope.() -> Unit
) = CoroutineScope(context).launch(context, start, block = block)

fun <T> runBlockingSilent(
        context: CoroutineContext = EmptyCoroutineContext,
        block: suspend CoroutineScope.() -> T
) {
    runBlocking(context, block)
}