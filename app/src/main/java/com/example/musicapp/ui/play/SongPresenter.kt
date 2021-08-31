package com.example.musicapp.ui.play

import android.util.Log
import com.example.musicapp.data.OnDataLocalCallback
import com.example.musicapp.data.SongRepository
import com.example.musicapp.model.Song
import com.example.musicappmvp.ui.play.SongInterface


class SongPresenter(private val view: SongInterface.View, private val repository: SongRepository) :
    SongInterface.Presenter {

    override fun getSongFromLocal() {
        repository.getAllSong(object : OnDataLocalCallback<List<Song>> {
            override fun onSucceed(data: List<Song>) {
                view.updateAdapter(data)
            }

            override fun onFailed(e: Exception?) {
                view.showError(e?.message.toString())
            }
        })
    }

}
