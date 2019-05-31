import matplotlib.pyplot as plt 
import numpy as np

valores = []
valores.append([17303, 15804, 15769])
valores.append([21175, 21140, 20835])
valores.append([45117, 44798, 42491])
valores.append([32874, 33477, 32458])
valores.append([79293, 79999, 78778])

valores.append([8788, 8389, 8357])
valores.append([12187, 11737, 11936])
valores.append([24420, 24366, 23874])
valores.append([21145, 18667, 19561])
valores.append([46888, 44358, 45524])

valores.append([8060, 6500, 6360])
valores.append([10247, 8910, 9026])
valores.append([17385, 17162, 17862])
valores.append([16337, 14244, 17427])
valores.append([34544, 33726, 32305])

valores.append([6258, 5142, 5367])
valores.append([8356, 7505, 9152])
valores.append([16594, 16332, 16634])
valores.append([14609, 13327, 15128])
valores.append([29697, 30413, 29804])

valores.append([8259, 7589, 7523])
valores.append([10785, 9828, 10366])
valores.append([19762, 21157, 20935])
valores.append([17359, 13486, 14939])
valores.append([30759, 28115, 27824])

valores.append([7262, 7229, 7496])
valores.append([9471, 8870, 8897])
valores.append([20850, 19607, 20238])
valores.append([17292, 13963, 12327])
valores.append([32987, 27062, 30824])

valores.append([6155, 5488, 5592])
valores.append([9215, 9127, 9175])
valores.append([16879, 17454, 17365])
valores.append([17268, 14689, 15038])
valores.append([32318, 32162, 33382])

valores.append([6167, 5868, 5828])
valores.append([8650, 8127, 8183])
valores.append([18168, 17874, 17980])
valores.append([16031, 14351, 16491])
valores.append([30755, 31059, 27186])

medias = []

for i in valores:
    medias.append(sum(i) / 3)

cont = 0
valores_59 = []
valores_161 = []
valores_256 = []
valores_1380 = []
valores_1601 = []

for i in medias:
    if cont > 4:
        cont = 0
    if cont == 0:
        valores_59.append(i)
    if cont == 1:
        valores_161.append(i)
    if cont == 2:
        valores_256.append(i)
    if cont == 3:
        valores_1380.append(i)
    if cont == 4:
        valores_1601.append(i)
    cont += 1


'''
eixox = ['Sequencial', '2 Threads', '3 Threads' ,'4 Threads', '5 Threads' ,'6 Threads' , '8 Threads', '10 Threads']
legenda = ['Base 59', 'Base 161', 'Base 256', 'Base 1380', 'Base 1601']
bar_width = 0.15
pos = np.arange(len(eixox))
pos2 = [x + bar_width for x in pos]
pos3 = [x + bar_width for x in pos2]
pos4 = [x + bar_width for x in pos3]
pos5 = [x + bar_width for x in pos4]



plt.bar(pos, valores_59, bar_width, color='blue', edgecolor='black')

plt.bar(pos2, valores_161, bar_width, color='pink', edgecolor='black')

plt.bar(pos3, valores_256, bar_width, color='orange', edgecolor='black')

plt.bar(pos4, valores_1380, bar_width, color='red', edgecolor='black')

plt.bar(pos5, valores_1601, bar_width, color='green', edgecolor='black')

plt.xticks([r + bar_width + 0.15 for r in range(len(valores_59))], eixox)
plt.ylabel('Tempo de Execução (ms)', fontsize=12)
plt.title('Tempo de Execução Médio das Bases com Threads',fontsize=12)
plt.legend(legenda,loc=0)
plt.show()
plt.close()
'''

eixox = [2,3,4,5,6,8,10]
base_59 = []
for i in valores_59:
    if i != valores_59[0]:
        base_59.append(valores_59[0]/i)

base_161 = []
for i in valores_161:
    if i != valores_161[0]:
        base_161.append(valores_161[0]/i)  

base_256 = []
for i in valores_256:
    if i != valores_256[0]:
        base_256.append(valores_256[0]/i)     

base_1380 = []
for i in valores_1380:
    if i != valores_1380[0]:
        base_1380.append(valores_1380[0]/i)       

base_1601 = []
for i in valores_1601:
    if i != valores_1601[0]:
        base_1601.append(valores_1601[0]/i)       

plt.plot(eixox, base_59,'-ok', label='Base 59')
plt.plot(eixox, base_256,'-ok', label='Base 256', color="blue")
plt.plot(eixox, base_161,'-ok', label='Base 161', color="orange")
plt.plot(eixox, base_1380,'-ok', label='Base 1380', color="green")
plt.plot(eixox, base_1601,'-ok', label='Base 1601', color="red")
plt.legend()
plt.xlabel('Quantidade de Threads')
plt.ylabel("Speedup")
plt.title("Speedup por quantidade de Threads")
plt.show()