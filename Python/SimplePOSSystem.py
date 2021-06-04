#訂餐系統
key = True
Userlist = []
foodlist = []
moneylist = []
allFood = ''
allUser = ''
allPeople = ''
allmoney = 0

def welcome():
    OrderStart = input('歡迎光臨麥當勞\n請問要內用還是外帶呢?   : ')
    while (OrderStart == '內用' or OrderStart == '外帶'):
        break
    if (OrderStart != '內用' or OrderStart != '外帶'):
            OrderStart = input ('請輸入內用或是外帶喔 !!   :')
        


def addUser():
    #增加訂餐者
    User = input('    請輸入姓名 : ')
    Userlist.append(User)#把人名加入List
    addFood()

def addFood():
    #增加訂餐者的餐點
    food = input('    要吃甚麼 : ')
    foodlist.append(food)#把食物加入List
    addMoney()

def addMoney():
    #增加價格
    money = int(input('    價格 : '))
    moneylist.append(money)

def setfood():
    #增加食物
    global allFood
    for v in range(len(foodlist)):
        allFood = allFood + ' ' + foodlist[v] 
    return '食物總結:' + allFood

def setUser():
    #所有人名
    global allUser
    for v in range(len(Userlist)):
        allUser = allUser + ' ' + Userlist[v]
    return '人名總結:' + allUser

def setMoney():
    #價錢加總
    global allmoney
    for v in range(len(moneylist)):
        allmoney += moneylist[v]
    return '金額總結:' + str(allmoney)

def printAll():
    #最後輸出
    global allPeople
    for v in range(len(moneylist)):
        allPeople = allPeople + Userlist[v] + '吃' + foodlist[v] + str(moneylist[v]) + "元  (" + OrderStart + ")\n"
    return allPeople
    

#--------------------------------------------------------------------------------------------
while(key == True):
    welcome()
    print('----------------------------------------------------')
    ifAddUser = input('若要新增請按 Y : ')

    if(ifAddUser == 'Y' or ifAddUser == 'y'):
        addUser()
    else:
        print('****************************************************')
        print(setfood())
        print(setUser())
        print('****************************************************')
        print(printAll())
        print(setMoney())
        key = False