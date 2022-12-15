package com.phinespec.moendemo.model

data class Item(
    val title: String?,
    val description: String?,
    val date: String?,
    val img: String?
) {

    companion object {
        val placeHolder = "No Title"
    }
}


/*
"title": "RecyclerView",
"description": "The RecyclerView is a ViewGroup that renders any adapter-based view in a similar way. It is supposed to be the successor of ListView and GridView. One of the reasons is that RecyclerView has a more extensible framework, especially since it provides the ability to implement both horizontal and vertical layouts. Use the RecyclerView widget when you have data collections whose elements change at runtime based on user action or network events.",
"date": "2022-05-18T15:15:50Z",
"img": "https://storage.googleapis.com/gweb-uniblog-publish-prod/images/Android_symbol_green_2.max-1500x1500.png"
 */