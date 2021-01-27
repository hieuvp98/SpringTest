var scripts = [
  {
    id: "1",
    title: "Tỉnh giấc",
    content:
      "Bạn thức dậy sau một giấc ngủ không biết là bao lâu nhưng có cảm giác khá lâu. Đầu bạn đau, cơ thể thì mệt mỏi. Bạn nhận ra mình đang ở trên cái giường quen thuộc của mình, căn phòng tối tăm. Bạn xem đồng hồ đeo tay thấy đang là 2h sáng, bạn nhìn ra ngoài cửa sổ, căn hộ của bạn ở tầng 24 nên tầm nhìn khá rộng. Ngoài trời mưa đang đổ chéo, thỉnh thoảng có tiếng sấm chớp, chỉ còn lại những chiếc đèn đường đang thắp sáng. Bình thường vẫn có những chiếc xe tải chạy ban đêm có tiếng kêu khá khó chịu nhưng bây giờ lại không có chiếc xe nào. Bỗng nhiên có tiếng bước chân nghe khá rõ ở ngoài phòng khách làm bạn chú ý.",
    selections: ["1A", "1B"],
  },
  {
    id: "1A",
    title: "Ra ngoài phòng khách",
    content:
      "Bạn thức Bạn mở cửa phòng, bước ra ngoài xem đó là ai. Một bóng người đang đứng ở gần cửa vào và đang nắm tay cửa. Trong bóng tối bạn không nhìn rõ mặt nhưng qua hình dáng bạn có thể nhận ra đó là vợ mình nhưng lẽ ra cô ấy đang ở nhà mẹ cách đây hơn 100km, hai bạn vừa có một cuộc cãi vã nên cô ấy bỏ nhà mẹ và không thèm liên lạc với bạn. sau một giấc ngủ không biết là bao lâu nhưng có cảm giác khá lâu. Đầu bạn đau, cơ thể thì mệt mỏi. Bạn nhận ra mình đang ở trên cái giường quen thuộc của mình, căn phòng tối tăm. Bạn xem đồng hồ đeo tay thấy đang là 2h sáng, bạn nhìn ra ngoài cửa sổ, căn hộ của bạn ở tầng 24 nên tầm nhìn khá rộng. Ngoài trời mưa đang đổ chéo, thỉnh thoảng có tiếng sấm chớp, chỉ còn lại những chiếc đèn đường đang thắp sáng. Bình thường vẫn có những chiếc xe tải chạy ban đêm có tiếng kêu khá khó chịu nhưng bây giờ lại không có chiếc xe nào. Bỗng nhiên có tiếng bước chân nghe khá rõ ở ngoài phòng khách làm bạn chú ý.",
    selections: [],
  },
  {
    id: "1B",
    title: "Tiếp tục ngủ",
    content:
      "Bạn thức Bạn chấn tĩnh lại bản thân và cho là mình nghe nhầm, bạn quay lại giường để tiếp tục giấc ngủ. Vì đang mệt nên bạn chìm vào giấc ngủ rất nhanh. Bỗng nhiên tiếng Tivi ở ngoài phòng khách làm bạn thức giấc lần nữa. Bạn xem đồng hồ, đang là 2h30, ngoài trời mưa gió đã bớt đi. sau một giấc ngủ không biết là bao lâu nhưng có cảm giác khá lâu. Đầu bạn đau, cơ thể thì mệt mỏi. Bạn nhận ra mình đang ở trên cái giường quen thuộc của mình, căn phòng tối tăm. Bạn xem đồng hồ đeo tay thấy đang là 2h sáng, bạn nhìn ra ngoài cửa sổ, căn hộ của bạn ở tầng 24 nên tầm nhìn khá rộng. Ngoài trời mưa đang đổ chéo, thỉnh thoảng có tiếng sấm chớp, chỉ còn lại những chiếc đèn đường đang thắp sáng. Bình thường vẫn có những chiếc xe tải chạy ban đêm có tiếng kêu khá khó chịu nhưng bây giờ lại không có chiếc xe nào. Bỗng nhiên có tiếng bước chân nghe khá rõ ở ngoài phòng khách làm bạn chú ý.",
    selections: [],
  },
];

function getScript(id) {
  return scripts.filter((s) => s.id === id)[0];
}
