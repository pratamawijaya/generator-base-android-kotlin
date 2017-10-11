package <%= appPackage %>.presentation.home

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.github.ajalt.timberkt.d
import com.github.nitrico.lastadapter.LastAdapter
import <%= appPackage %>.BR
import <%= appPackage %>.R
import <%= appPackage %>.data.PreferencesManager
import <%= appPackage %>.di.component.ActivityComponent
import <%= appPackage %>.entity.Hero
import <%= appPackage %>.presentation.base.BaseInjectedActivity
import javax.inject.Inject

class MainActivity : BaseInjectedActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter
    @Inject
    lateinit var prefManager: PreferencesManager

    @BindView(R.id.rvMain)
    lateinit var rvMain: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        setupRecyclerView()

        presenter.attachView(this)
        presenter.getHeroes()

        prefManager.saveString(PreferencesManager.PREF_USERNAME, "hello")

    }

    private fun setupRecyclerView() {
        rvMain.layoutManager = LinearLayoutManager(this)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun injectModule(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun displayHeroes(heroes: List<Hero>) {

        LastAdapter(heroes, BR.hero)
                .map<Hero>(R.layout.item_heroes)
                .into(rvMain)

        heroes.map {
            d { "heroes ${it.localName} ${it.id}" }
            d { "heroes image ${it.heroesImage}" }
            d { "heroes role ${it.roles.toString()}" }
        }
    }
}
