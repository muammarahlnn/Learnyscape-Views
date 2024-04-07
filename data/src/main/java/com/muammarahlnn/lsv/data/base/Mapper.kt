package com.muammarahlnn.lsv.data.base

/**
 * @Author Muammar Ahlan Abimanyu
 * @File Mapper, 30/03/2024 20.51
 */
fun interface Mapper<F, T> {

    fun map(from: F): T
}