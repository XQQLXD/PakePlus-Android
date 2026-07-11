package com.app.pakeplus

object GallerySaveDecider {
    private val imageMimePrefixes = listOf("image/")
    private val imageExtensions = setOf("png", "jpg", "jpeg", "gif", "webp", "bmp", "heic", "heif")

    @JvmStatic
    fun shouldSaveToGallery(mimeType: String?, fileName: String?): Boolean {
        val normalizedMimeType = mimeType?.trim()?.lowercase().orEmpty()
        if (imageMimePrefixes.any { normalizedMimeType.startsWith(it) }) {
            return true
        }

        val extension = fileName
            ?.substringAfterLast('.', "")
            ?.trim()
            ?.lowercase()
            .orEmpty()

        return extension in imageExtensions
    }
}

