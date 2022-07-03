package com.jorgecamarena.android.client.basicInjection

import javax.inject.Inject

/**
 * Created by jorgecordero on Jul, 02, 2022
 **/
class TestRepository @Inject constructor(
    private val innerDependency: TestRepositoryInnerDependency
) {
    fun testMethod() {
        innerDependency.runSomeDummyTest()
    }
}