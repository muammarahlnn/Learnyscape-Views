package com.muammarahlnn.lsv.domain.login

import com.muammarahlnn.lsv.data.login.LoginRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File IsUserLoggedInUseCase, 08/04/2024 04.53
 */
class IsUserLoggedInUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
) {

    fun execute(): Boolean = runBlocking {
        loginRepository.isUserLoggedIn().first()
    }
}