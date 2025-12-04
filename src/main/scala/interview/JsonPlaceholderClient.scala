package interview

import cats.effect._
import org.http4s._
import org.http4s.client.Client
import org.http4s.circe.CirceEntityCodec._

class JsonPlaceholderClient[F[_]: Concurrent](client: Client[F]) {

  private val baseUri = Uri.uri("https://jsonplaceholder.typicode.com")

  /** Fetches a user by ID from JSONPlaceholder API */
  def getUser(userId: Int): F[User] = {
    val uri = baseUri / "users" / userId.toString
    client.expect[User](uri)
  }

  // TODO: Implement getPosts to fetch posts for a given userId
  // Endpoint: GET https://jsonplaceholder.typicode.com/posts?userId={userId}
  // def getPosts(userId: Int): F[List[Post]] = ???

}

object JsonPlaceholderClient {
  def apply[F[_]: Concurrent](client: Client[F]): JsonPlaceholderClient[F] =
    new JsonPlaceholderClient[F](client)
}
