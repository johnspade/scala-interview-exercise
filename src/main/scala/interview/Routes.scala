package interview

import cats.effect._
import cats.syntax.all._
import org.http4s._
import org.http4s.dsl.Http4sDsl
import org.http4s.circe.CirceEntityCodec._

class Routes[F[_]: Concurrent](client: JsonPlaceholderClient[F]) extends Http4sDsl[F] {

  val routes: HttpRoutes[F] = HttpRoutes.of[F] {

    // Health check
    case GET -> Root / "health" =>
      Ok("OK")

    // Fetch a user by ID
    case GET -> Root / "user" / IntVar(userId) =>
      client.getUser(userId).flatMap(Ok(_))

    // TODO: Add endpoint GET /user/{userId}/with-posts
    // This should fetch both the user AND their posts, returning them together
    // Hint: Use the client methods and combine the results

  }
}

object Routes {
  def apply[F[_]: Concurrent](client: JsonPlaceholderClient[F]): Routes[F] =
    new Routes[F](client)
}
