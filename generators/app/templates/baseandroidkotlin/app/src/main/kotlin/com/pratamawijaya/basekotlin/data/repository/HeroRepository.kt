package <%= appPackage %>.data.repository

import <%= appPackage %>.entity.Hero
import io.reactivex.Observable

/**
 * Created by pratama on 8/7/17.
 */
interface HeroRepository {
    fun getHeroes(): Observable<List<Hero>>
}