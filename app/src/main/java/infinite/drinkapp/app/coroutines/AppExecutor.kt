package infinite.drinkapp.app.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext

private const val NETWORK_THREAD_NAME = "network"

class AppExecutor : Executor {
    override val io = Dispatchers.IO
    override val ui = Dispatchers.Main
    @ObsoleteCoroutinesApi
    override val net = newSingleThreadContext(NETWORK_THREAD_NAME)
}