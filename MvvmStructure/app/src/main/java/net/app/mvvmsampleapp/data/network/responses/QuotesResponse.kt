package net.app.mvvmsampleapp.data.network.responses

import net.app.mvvmsampleapp.data.db.entities.Quote

data class QuotesResponse (
    val isSuccessful: Boolean,
    val quotes: List<Quote>
)