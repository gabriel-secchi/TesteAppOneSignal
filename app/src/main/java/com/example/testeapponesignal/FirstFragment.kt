package com.example.testeapponesignal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.testeapponesignal.databinding.FragmentFirstBinding
import com.onesignal.OneSignal

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val oneSignalHandler by lazy {
        val app = this.activity?.application as MyApplication
        app.getOnSignalInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSetId.setOnClickListener {
            OneSignal.setExternalUserId("12345")
        }
        binding.btnDelId.setOnClickListener {
            OneSignal.removeExternalUserId()
        }

        binding.btnAddTag.setOnClickListener {
            OneSignal.sendTag("product_id", "0001")
        }
        binding.btnDelTag.setOnClickListener {
            OneSignal.deleteTag("product_id")
        }

        binding.btnDisablePush.setOnClickListener {
            OneSignal.disablePush(true)
        }
        binding.btnEnablePush.setOnClickListener {
            OneSignal.disablePush(false)
        }
    }

    override fun onResume() {
        super.onResume()
        instance = this
        oneSignalHandler.runPendingHandlers()
    }

    override fun onStop() {
        super.onStop()
        instance = null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        instance = null
        _binding = null
    }

    fun goToSecondFragment(productId: String) {
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
    }

    companion object {
        var instance: FirstFragment? = null
    }
}