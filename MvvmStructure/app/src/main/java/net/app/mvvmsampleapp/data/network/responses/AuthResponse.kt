package net.app.mvvmsampleapp.data.network.responses

import net.app.mvvmsampleapp.data.db.entities.User

data class AuthResponse(
    val isSuccessful : Boolean?,
    val message: String?,
    val user: User?
)