package infinite.drinkapp.app.coroutines

import kotlin.coroutines.CoroutineContext


interface Executor {
    val io: CoroutineContext
    val ui: CoroutineContext
    val net: CoroutineContext
}