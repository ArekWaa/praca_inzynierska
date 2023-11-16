package com.example.generalowiewiary.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.generalowiewiary.databinding.FragmentBiographyBinding

class PhotosFragment : Fragment() {

    private var _binding: FragmentBiographyBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val photosViewModel =
            ViewModelProvider(this).get(PhotosViewModel::class.java)

        _binding = FragmentBiographyBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textPhotos
//        biographyViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}