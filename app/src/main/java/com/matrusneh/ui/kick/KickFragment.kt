package com.matrusneh.ui.kick

import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.matrusneh.databinding.FragmentKickBinding

class KickFragment : Fragment() {

    private var _binding: FragmentKickBinding? = null
    private val binding get() = _binding!!

    private val vm: KickViewModel by viewModels()

    private val adapter = KicksPerHourAdapter()

    private var lastAcceptedTapElapsed: Long = 0L

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentKickBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerKicks.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerKicks.adapter = adapter

        binding.btnKick.setOnClickListener {
            val nowElapsed = SystemClock.elapsedRealtime()
            if (nowElapsed - lastAcceptedTapElapsed < 1000L) return@setOnClickListener // debounce 1 sec
            lastAcceptedTapElapsed = nowElapsed

            vm.logKick(System.currentTimeMillis())
        }

        vm.state.observe(viewLifecycleOwner) { state ->
            binding.textTotalToday.text = state.totalToday.toString()
            binding.textLastKick.text = state.lastKickText
            adapter.submitList(state.rows)
        }

        vm.refresh()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

