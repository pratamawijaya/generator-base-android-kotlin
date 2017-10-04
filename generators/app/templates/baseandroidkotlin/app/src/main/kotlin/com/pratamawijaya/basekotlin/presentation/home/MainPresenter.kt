package <%= appPackage %>.presentation.home

import com.github.ajalt.timberkt.d
import com.github.ajalt.timberkt.e
import <%= appPackage %>.data.repository.HeroRepository
import <%= appPackage %>.presentation.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by pratama on 8/7/17.
 */
class MainPresenter @Inject constructor(val repo: HeroRepository) : BasePresenter<MainView>() {

    private var compositeSub = CompositeDisposable()

    override fun attachView(mView: MainView) {
        super.attachView(mView)
    }

    override fun detachView() {
        super.detachView()
    }

    /**
     * get dota 2 heroes list
     */
    fun getHeroes() {
        compositeSub.add(repo.getHeroes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    d { "hasilnya adalah" }
                    mView?.displayHeroes(result)
                }, { error ->
                    e { "error ${error.localizedMessage}" }
                }))
    }
}