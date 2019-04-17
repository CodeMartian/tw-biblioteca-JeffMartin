--1. Who checked out the book 'The Hobbit?'

SELECT m.name,
        b.title
FROM member m
LEFT JOIN checkout_item ci ON m.id = ci.member_id
LEFT JOIN book b ON b.id = ci.book_id
WHERE b.title = 'The Hobbit';

-- Answer: Anand Beck

--2. How many people have not checked out anything?

SELECT COUNT(m.id)
FROM member m
LEFT JOIN checkout_item ci ON m.id = ci.member_id
WHERE ci.book_id IS NULL AND ci.movie_id IS NULL;

-- Answer: 37

-- 3. What books and movies aren't checked out?

SELECT b.title,
        m.title
FROM checkout_item ci
LEFT OUTER JOIN book b ON b.id = ci.book_id
LEFT OUTER JOIN movie m ON m.id = ci.movie_id

-- Answer:

-- 4. Add the book 'The Pragmatic Programmer', and add yourself as a member. 
--    Check out 'The Pragmatic Programmer'.
--    Use the query from question 1 to verify you have checked it out.

-- 5. Who has checked out more than one item?
