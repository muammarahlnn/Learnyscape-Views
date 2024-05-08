package com.muammarahlnn.lsv.core.ui.util

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.os.Environment
import android.provider.OpenableColumns
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

/**
 * @Author Muammar Ahlan Abimanyu
 * @File FileHelper, 08/05/2024 18.08
 */

fun Uri.toFile(context: Context): File {
    val file = createFile(context, this)
    val contentResolver = context.contentResolver

    val inputStream = contentResolver.openInputStream(this) as InputStream
    val outputStream = FileOutputStream(file)
    val buf = ByteArray(1024)

    var len: Int
    while (inputStream.read(buf).also { len = it } > 0) {
        outputStream.write(buf, 0, len)
    }
    outputStream.close()
    inputStream.close()

    return file
}

fun createFile(context: Context, uri: Uri): File {
    val storageDir: File? = context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
    val filename = getFileName(context, uri)
    return File(storageDir, filename)
}

fun getFileName(context: Context, uri: Uri): String {
    var fileName = ""
    if (uri.scheme == ContentResolver.SCHEME_CONTENT) {
        val contentResolver = context.contentResolver
        val cursor = contentResolver.query(uri, null, null, null, null)
        cursor.use {
            if (it != null && it.moveToFirst()) {
                fileName += it.getString(it.getColumnIndexOrThrow(OpenableColumns.DISPLAY_NAME))
            }
        }
    }

    if (fileName.isEmpty()) {
        fileName = uri.path.orEmpty()
        val separatorIndex = fileName.lastIndexOf('/')
        if (separatorIndex != -1) fileName = fileName.substring(separatorIndex + 1)
    }

    return fileName
}