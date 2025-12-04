package interview

import cats.effect._
import munit.CatsEffectSuite
import org.http4s._
import org.http4s.implicits._
import org.http4s.circe.CirceEntityCodec._

class RoutesSpec extends CatsEffectSuite {

  // Stub client that returns fixed test data
  val stubClient: JsonPlaceholderClient[IO] = new JsonPlaceholderClient[IO](null) {
    override def getUser(userId: Int): IO[User] = IO.pure(
      User(
        id = userId,
        name = "Test User",
        username = "testuser",
        email = "test@example.com"
      )
    )

    // TODO: Override getPosts to return test data
    // override def getPosts(userId: Int): IO[List[Post]] = ???
  }

  val routes: HttpRoutes[IO] = Routes(stubClient).routes

  // Helper to run requests
  def check[A](
    req: Request[IO],
    expectedStatus: Status
  ): IO[Response[IO]] = {
    routes.orNotFound.run(req).flatMap { response =>
      IO(assertEquals(response.status, expectedStatus)).as(response)
    }
  }

  // ============================================
  // Example test (already passing)
  // ============================================

  test("GET /user/{id} returns user") {
    val request = Request[IO](Method.GET, uri"/user/1")

    for {
      response <- check(request, Status.Ok)
      user     <- response.as[User]
    } yield {
      assertEquals(user.id, 1)
      assertEquals(user.name, "Test User")
    }
  }

  // ============================================
  // TODO: Add test for the new endpoint
  // ============================================
}
