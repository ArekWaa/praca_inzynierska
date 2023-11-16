package com.example.generalowiewiary.ui.videos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.generalowiewiary.databinding.FragmentVideosBinding

class VideosFragment : Fragment() {

    private var _binding: FragmentVideosBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val videosViewModel =
            ViewModelProvider(this).get(VideosViewModel::class.java)

        _binding = FragmentVideosBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textVideos
        videosViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}