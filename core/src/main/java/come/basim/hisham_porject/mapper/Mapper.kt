package come.basim.hisham_porject.mapper

interface Mapper<S, D> {

    fun map(source: S): D

    fun mapList(source: List<S>): List<D> {
        return source.map(::map)
    }
}