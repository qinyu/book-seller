# language: zh-CN

功能: 书籍价格查询
  作为一个顾客
  我想要知道书籍的价格
  以便决定是否需要下单

  背景：
    假如 "Kotlin in Action"的价格是"89.00", 作者是"qinyu", ISBN是"9787121321580"
    而且 "Implementing DDD"的价格是"99.00", 作者是"Vaughn Vernon", ISBN是"9787121224485"
    而且 "DDD Distilled"的价格是"65.00", 作者是"Vaughn Vernon", ISBN是"9787121348525"

  场景: 根据书名查询
    当 我用"Kotlin"作为书名查询时
    那么 我得到的书单应该是"Kotlin in Action"

  场景: 根据书名查询
    当 我用"DDD"作为书名查询时
    那么 我得到的书单应该是"Implementing DDD"和"DDD Distilled"

  场景: 根据作者查询
    当 我用"Vaughn Vernon"作为作者查询时
    那么 我得到的书单应该是"Implementing DDD"和"DDD Distilled"




