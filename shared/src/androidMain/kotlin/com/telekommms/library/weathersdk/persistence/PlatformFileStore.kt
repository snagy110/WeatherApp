package com.telekommms.library.weathersdk.persistence

import android.content.Context
import android.content.ContextWrapper
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException

class PlatformFileStore(private val context: Context) {
    companion object {
        private const val TAG: String = "PLATFORM_FILE_STORE"
    }

    private val storagePath: String = "/storage/self/primary/Documents/PlatformFileStore"

    fun writeToFile(fileName: String, fileContent: String) {
        try {
            val dir = File(storagePath)
            if (!dir.exists()) {
                dir.mkdirs()
            }
            val file = File(storagePath, fileName)
            if (file.exists()) {
                if (file.canWrite()) {
                    file.appendText(fileContent)
                } else {
                    file.delete()
                    file.createNewFile()
                    file.appendText(fileContent)
                }
            } else {
                file.createNewFile()
                file.appendText(fileContent)
            }
        }
        catch (e: FileNotFoundException) {
        }
        catch (e: Exception) {
        }
    }

    fun readFromFile(fileName: String): String? {
        val path = ContextWrapper(context)
        val letDirectory = path.getDir(storagePath, Context.MODE_PRIVATE)
        if (!letDirectory.isDirectory) {
            return "File Not Found"
        } else {

            val userDataFile = File(letDirectory, fileName)
            var userData = ""
            userData = if (userDataFile.isFile) {
                FileInputStream(userDataFile).bufferedReader().use {
                    it.readText()
                }
            } else {
                "File Not Found"
            }
            return userData
        }
    }

    fun removeFile(fileName: String) {
        val path = ContextWrapper(context)
        val letDirectory = path.getDir(storagePath, Context.MODE_PRIVATE)
        val userDataFile = File(letDirectory, fileName)
        userDataFile.outputStream().use {
            it.flush()
        }
    }
}

/**
 * TODD
 */