package net.app.mvvmsampleapp.ui.home.quotes

import com.xwray.groupie.databinding.BindableItem
import net.app.mvvmsampleapp.R
import net.app.mvvmsampleapp.data.db.entities.Quote
import net.app.mvvmsampleapp.databinding.ItemQuoteBinding

class QuoteItem(
    private val quote: Quote
) : BindableItem<ItemQuoteBinding>(){

    override fun getLayout() = R.layout.item_quote

    override fun bind(viewBinding: ItemQuoteBinding, position: Int) {
        viewBinding.setQuote(quote)
    }
}