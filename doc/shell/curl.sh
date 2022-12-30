# 发送POST请求
# curl -X POST -H "Accept:application/json" -H "Content-Type:application/json" -d '{"type":4,"name":"ORDER_ID_RATE","value":"5"}' 'https://yunbusiness.ccb.com/clp_order/inner/switch?txcode=A3341O999'

# 切服务方 充值中心
curl -X POST -H "Accept:application/json" -H "Content-Type:application/json" -d '{"type":2,"name":"YS44000008000278","value":"0"}' 'https://yunbusiness.ccb.com/clp_order/inner/switch?txcode=A3341O999'

# 切服务方 车主
# curl -X POST -H "Accept:application/json" -H "Content-Type:application/json" -d '{"type":2,"name":"YS44000010000032","value":"1"}' 'https://yunbusiness.ccb.com/clp_order/inner/switch?txcode=A3341O999'

# 切服务方 二维火
# curl -X POST -H "Accept:application/json" -H "Content-Type:application/json" -d '{"type":2,"name":"YS44000010000042","value":"1"}' 'https://yunbusiness.ccb.com/clp_order/inner/switch?txcode=A3341O999'

# 切服务方 约惠四川
# curl -X POST -H "Accept:application/json" -H "Content-Type:application/json" -d '{"type":2,"name":"YS44000001000242","value":"1"}' 'https://yunbusiness.ccb.com/clp_order/inner/switch?txcode=A3341O999'