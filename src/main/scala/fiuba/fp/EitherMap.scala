package fiuba.fp

sealed trait MapError
case object NoContent extends MapError

class EitherMap[K,+V](val m: Map[K,V]){

    def get(key: K): Either[MapError,V] = {
        m.get(key) match {
            case None => Left(NoContent)
            case Some(value) => Right(value)
        }
    }

}