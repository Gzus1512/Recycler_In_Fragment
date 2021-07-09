package jesus.rosas.recycler_in_fragment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jesus.rosas.recycler_in_fragment.R
import jesus.rosas.recycler_in_fragment.adapters.RecyclerViewAdapter
import jesus.rosas.recycler_in_fragment.models.DataModel

class MainFragment : Fragment(), RecyclerViewAdapter.ClickListener {

    private lateinit var adapter: RecyclerViewAdapter
    val listData: ArrayList<DataModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        buildDisplayData()
        initRecyclerView(view)
        return view
    }

    private fun initRecyclerView(view: View) {
        val recylcerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recylcerView.layoutManager = LinearLayoutManager(activity)
        adapter = RecyclerViewAdapter(listData, this)
        recylcerView.adapter = adapter
    }

    companion object {

        @JvmStatic fun newInstance() =
                MainFragment().apply {
                    arguments = Bundle().apply {
                    }
                }
    }

    private fun buildDisplayData() {
        listData.add(DataModel("Country"))
        listData.add(DataModel("Local"))
        listData.add(DataModel("International"))
    }

    override fun onItemClick(dataModel: DataModel) {
        val fragment: Fragment = DetailFragment.newInstance(dataModel.title!!)
        val transaction = activity?.supportFragmentManager!!.beginTransaction()
        transaction.hide(activity?.supportFragmentManager!!.findFragmentByTag("main_fragment")!!)
        transaction.add(R.id.frameContainer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}