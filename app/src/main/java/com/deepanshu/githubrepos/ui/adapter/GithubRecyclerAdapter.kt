package com.deepanshu.githubrepos.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.deepanshu.githubrepos.R

import com.deepanshu.githubrepos.model.GithubRepo
import kotlinx.android.synthetic.main.item_github_repo.view.*

import java.util.ArrayList

class GithubRecyclerAdapter(private val mContext: Context) : RecyclerView.Adapter<GithubRecyclerAdapter.GitHubRepoViewHolder>() {
    private val gitHubRepos = ArrayList<GithubRepo>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitHubRepoViewHolder {
        val inflater = LayoutInflater.from(mContext)
        val view = inflater.inflate(R.layout.item_github_repo, parent, false)
        return GitHubRepoViewHolder(view)
    }

    override fun onBindViewHolder(holder: GitHubRepoViewHolder, position: Int) {
        holder.bindViews(gitHubRepos[position])
    }

    fun setGitHubRepos(repos: List<GithubRepo>?) {
        if (repos == null) {
            return
        }
        gitHubRepos.clear()
        gitHubRepos.addAll(repos)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return gitHubRepos.size
    }

    inner class GitHubRepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindViews(githubRepo: GithubRepo){
            itemView.text_repo_name.text = githubRepo.name
            itemView.text_repo_description.text = githubRepo.description
            itemView.text_language.text = String.format("Language: %s",githubRepo.language)
            itemView.text_stars.text = String.format("Stars: %s",githubRepo.stargazers_count)
        }
    }

}
