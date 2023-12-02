
/*
An MMORPG game is under development. For hte profile and inventory mechanics,
  it needs a query that calculates a list of game accounts whose inventory is overloaded with game items.
The result should have hte following columns: username / email | items / total_weight.
• username - account username • email - account email address
• Items -total number of items ni inventory
• total weight - total weight of items in inventory
The result should be sorted in descending order by total weight, then in ascending order by username.
Note:
    • Each time in the inventory has its won weight.
    • Only accounts where het total weight of all items in the inventory
        exceeds the overload threshold should be included in the result.
    • The overload threshold is 20.
Schema
                    accounts
name        type            constraint      description
id          integer         primary key     Account ID
username    varchar(255)                    Account username
email       varchar(255)                    Account email address

                    items
name        type            constraint      description
id          integer         primary key     Item ID
type        varchar(255)                    Item type
name        varchar(255)                    Item name
weight      integer                         weight of item

                    accounts_items
name        type            constraint      description
account_id  intemger                        Account ID
item_id     varchar(255)                    Item ID

*/


SELECT a.username, a.email, COUNT(ai.item_id) AS items, SUM(i.weight) AS total_weight
FROM accounts AS a
         JOIN accounts_items AS ai ON a.id = ai.account_id
         JOIN items AS i ON ai.item_id = i.id
GROUP BY a.username, a.email
HAVING total_weight > 20
ORDER BY total_weight DESC, a.username ASC;