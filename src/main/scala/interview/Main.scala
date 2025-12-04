package interview

import cats.effect._
import com.comcast.ip4s._
import org.http4s.ember.client.EmberClientBuilder
import org.http4s.ember.server.EmberServerBuilder

object Main extends IOApp.Simple {

  def run: IO[Unit] = {
    EmberClientBuilder
      .default[IO]
      .build
      .flatMap { httpClient =>
        val apiClient = JsonPlaceholderClient(httpClient)
        val routes = Routes(apiClient).routes

        EmberServerBuilder
          .default[IO]
          .withHost(host"0.0.0.0")
          .withPort(port"8080")
          .withHttpApp(routes.orNotFound)
          .build
      }
      .useForever
  }
}
