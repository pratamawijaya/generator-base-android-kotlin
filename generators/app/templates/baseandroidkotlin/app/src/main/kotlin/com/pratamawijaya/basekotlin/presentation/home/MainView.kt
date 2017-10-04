package <%= appPackage %>.presentation.home

import <%= appPackage %>.entity.Hero
import <%= appPackage %>.presentation.base.BaseView

/**
 * Created by pratama on 8/7/17.
 */
interface MainView : BaseView {
    fun displayHeroes(heroes: List<Hero>)
}