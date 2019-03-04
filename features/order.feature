# language: zh-CN

功能: 书籍信息
  作为一个顾客
  我想要把想买的书籍加到订单中并计算出价格
  以便支付

  背景：
    假如 "Kotlin in Action"的价格是"89.00", 作者是"qinyu", ISBN是"9787121321580"
    而且 "Implementing DDD"的价格是"99.00", 作者是"Vaughn vernon", ISBN是"9787121224485"
    而且 "DDD Distilled"的价格是"65.00", 作者是"Vaughn vernon", ISBN是"9787121348525"

  场景: 只买一本书
    当 我把1本"Implementing DDD"添加到订单
    那么 我看到的订单价格应该是"99.00"


  场景: 两本书各买一本
    当 我把1本"Implementing DDD"和1本"DDD Distilled"添加到订单
    那么 我看到的订单价格应该是"164.00"


  场景: 两本书各买两本
    当 我把2本"Implementing DDD"和2本"DDD Distilled"添加到订单
    那么 我看到的订单价格应该是"328.00"
    





