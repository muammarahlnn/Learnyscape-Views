package com.muammarahlnn.lsv.network.di

import javax.inject.Qualifier

/**
 * @Author Muammar Ahlan Abimanyu
 * @File AuthQualifiers, 30/03/2024 03.51
 */

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Auth(val qualifiers: AuthQualifiers)

enum class AuthQualifiers {
    DEFAULT,
    BEARER_TOKEN
}
