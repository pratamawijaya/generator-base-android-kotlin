package <%= appPackage %>.presentation.home

import com.github.ajalt.timberkt.d
import com.github.ajalt.timberkt.e
import <%= appPackage %>.data.PreferencesManager
import <%= appPackage %>.data.repository.HeroRepository
import <%= appPackage %>.presentation.base.BasePresenter
import <%= appPackage %>.utils.RxUtils
import javax.inject.Inject

/**
 * Created by pratama on 8/7/17.
 */
class MainPresenter @Inject constructor(private val repo: HeroRepository,
                                        private val preferencesManager: PreferencesManager) : BasePresenter<MainView>() {

    /**
     * get dota 2 heroes list
     */
    fun getHeroes() {
        mView?.showLoading()
        preferencesManager.setUserLogin(true)
        compositeDisposable.add(repo.getHeroes()
                .compose(RxUtils.applyObservableAsync())
                .subscribe({ result ->
                    mView?.hideLoading()
                    d { "hasilnya adalah" }
                    mView?.displayHeroes(result)
                }, { error ->
                    mView?.hideLoading()
                    e { "error ${error.localizedMessage}" }
                }))
    }
}