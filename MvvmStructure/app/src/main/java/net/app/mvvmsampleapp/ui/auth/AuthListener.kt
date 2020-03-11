package net.app.mvvmsampleapp.ui.auth

import net.app.mvvmsampleapp.data.db.entities.User

interface AuthListener {
    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message: String)
}