package interview

import io.circe.{Decoder, Encoder}
import io.circe.generic.semiauto._

// User from JSONPlaceholder API
case class User(
  id: Int,
  name: String,
  username: String,
  email: String
)

object User {
  implicit val decoder: Decoder[User] = deriveDecoder[User]
  implicit val encoder: Encoder[User] = deriveEncoder[User]
}

// Post from JSONPlaceholder API
case class Post(
  userId: Int,
  id: Int,
  title: String,
  body: String
)

object Post {
  implicit val decoder: Decoder[Post] = deriveDecoder[Post]
  implicit val encoder: Encoder[Post] = deriveEncoder[Post]
}

// TODO: Define a response model for the new endpoint
// case class UserWithPosts(...)
