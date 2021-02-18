package com.mynews.ui.home.model

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.facebook.drawee.view.SimpleDraweeView
import com.mynews.R
import com.mynews.ui.home.HomeController

@EpoxyModelClass(layout = R.layout.epoxy_news_article)
abstract class NewsArticleViewModel : EpoxyModelWithHolder<NewsArticleViewModel.Holder>() {
    @EpoxyAttribute
    lateinit var articleId: String

    @EpoxyAttribute
    lateinit var title: String

    @EpoxyAttribute
    lateinit var description: String

    @EpoxyAttribute
    lateinit var image: String

    @EpoxyAttribute
    lateinit var callback: HomeController.HomepageCallBacks

    override fun bind(holder: Holder) {
        holder.articleTitle.text = title
        holder.articleDescription.text = description
        holder.articleImage.setImageURI(image)
        holder.layout.setOnClickListener {
            callback.onArticleClicked(articleId)
        }
    }

    inner class Holder : EpoxyHolder() {
        lateinit var articleTitle: TextView
        lateinit var articleDescription: TextView
        lateinit var articleImage: SimpleDraweeView
        lateinit var layout: ConstraintLayout
        override fun bindView(itemView: View) {
            articleTitle = itemView.findViewById(R.id.title)
            articleDescription = itemView.findViewById(R.id.description)
            articleImage = itemView.findViewById(R.id.image)
            layout = itemView.findViewById(R.id.container)
        }
    }
}