package com.jorgecamarena.android.client.multipleImplementations

/**
 * Created by jorgecordero on Jul, 03, 2022
 **/
class MultiImplementationRepo(
    private val dao: FakeDao
) {
    fun runSomeStuff() {
        dao.runSomeMethod()
    }
}