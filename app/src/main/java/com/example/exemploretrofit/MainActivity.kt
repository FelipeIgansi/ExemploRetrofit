package com.example.exemploretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val remote = RetrofitClient.createService(PostService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val call: Call<List<PostEntity>> = remote.list()
        call.enqueue(object : Callback<List<PostEntity>> {
            override fun onFailure(call: Call<List<PostEntity>>, t: Throwable) {
                val fail = t.message
            }

            override fun onResponse(call: Call<List<PostEntity>>, rsp: Response<List<PostEntity>>) {
                val list = rsp.body()
            }

        })
    }


    /**
     * https://jsonplaceholder.typicode.com/posts // retorna lista
    {
    "userId": 1,
    "id": 1,
    "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
    "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
    },
     *
     * */
}