package com.geektech.hw_3_8

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.geektech.hw_3_8.databinding.FragmentSecondBinding
import com.geektech.hw_3_8.model.HeroModel

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private lateinit var navArgs: SecondFragmentArgs
    private lateinit var heroList: ArrayList<HeroModel>
    private var position = 0
    private var size = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initArgs()

        setData(position)

        binding.btnBackDetail.setOnClickListener {
            position -= 1
            setData(position)
        }

        binding.btnNextDetail.setOnClickListener {
            position += 1
            setData(position)
        }



    }
    private fun initArgs(){
        arguments?.let{
            navArgs = SecondFragmentArgs.fromBundle(it)
        }

        heroList = navArgs.heroList as ArrayList<HeroModel>
        position = navArgs.position
        size = heroList.size


    }

    private fun setData(position: Int) {

        binding.tvNameDetail.text = heroList!![position].name
        binding.tvStatusDetail.text = heroList[position].status
        Glide.with(binding.ivAvatarDetail).load(heroList[position].image)
            .into(binding.ivAvatarDetail)

        if (position - 1 < 0) {
            binding.btnBackDetail.visibility = View.GONE
        } else if (position + 1 == size) {
            binding.btnNextDetail.visibility = View.GONE
        } else{
            binding.btnBackDetail.visibility = View.VISIBLE
            binding.btnNextDetail.visibility = View.VISIBLE
        }
    }
}