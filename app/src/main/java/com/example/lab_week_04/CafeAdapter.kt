package com.example.lab_week_04

import android.os.Bundle
import androidx.core.content.ContextCompat.getString
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

val TABS_FIXED = listOf(
    R.string.starbucks_title,
    R.string.janjijiwa_title,
    R.string.kopikenangan_title
)

class CafeAdapter(private val fragment: Fragment) :
    FragmentStateAdapter(fragment) {
    private var TAB_CONTENT = "TAB_CONTENT"

    override fun getItemCount(): Int {
        return TABS_FIXED.size
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CafeDetailFragment().apply {
                arguments = bundleOf(
                    "TAB_CONTENT" to fragment.getString(R.string.starbucks_desc),
                )
            }

            1 -> CafeDetailFragment().apply {
                arguments = bundleOf(
                    "TAB_CONTENT" to fragment.getString(R.string.janjijiwa_desc),
                )
            }


            2 -> CafeDetailFragment().apply {
                arguments = bundleOf(
                    "TAB_CONTENT" to fragment.getString(R.string.kopikenangan_desc),
                )
            }

            else -> throw IllegalStateException("Invalid position $position")
        }
    }
}