# Interview Exercise: User Posts Aggregation

## Context

This is a simple http4s service that acts as a proxy to the [JSONPlaceholder API](https://jsonplaceholder.typicode.com/).

Currently, the service has one working endpoint:
- `GET /user/{id}` - Returns user information

## Your Task

Implement a new endpoint that returns a user along with their posts:

**`GET /user/{userId}/with-posts`**

This endpoint should:
1. Fetch the user from JSONPlaceholder
2. Fetch the user's posts from JSONPlaceholder
3. Return a combined response

### Example Response

```json
{
  "user": {
    "id": 1,
    "name": "Leanne Graham",
    "username": "Bret",
    "email": "Sincere@april.biz"
  },
  "posts": [
    {
      "userId": 1,
      "id": 1,
      "title": "sunt aut facere...",
      "body": "quia et suscipit..."
    }
  ]
}
```

## What You Need To Do

1. **In `Models.scala`**: Define a `UserWithPosts` case class with appropriate circe codecs

2. **In `JsonPlaceholderClient.scala`**: Implement the `getPosts` method
   - Endpoint: `GET https://jsonplaceholder.typicode.com/posts?userId={userId}`

3. **In `Routes.scala`**: Add the new route that combines both calls

## Hints

- Look at the existing `getUser` implementation for reference
- For query parameters in http4s client: `baseUri / "posts" +? ("userId" -> userId)`
- You can use `parMapN` or sequential `flatMap` to combine the two calls

## Running the Server

```bash
sbt run
```

Then test with:
```bash
curl http://localhost:8080/user/1
curl http://localhost:8080/user/1/with-posts
```

## JSONPlaceholder Endpoints Reference

- Users: https://jsonplaceholder.typicode.com/users/1
- Posts by user: https://jsonplaceholder.typicode.com/posts?userId=1
