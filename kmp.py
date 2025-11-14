import matplotlib.pyplot as plt

outputs = [
    {"pattern":"a","textLength":5,"matches":[0,2],"timeMs":0.005},
    {"pattern":"aba","textLength":5,"matches":[0,2],"timeMs":0.019},
    {"pattern":"needle","textLength":51,"matches":[10,31],"timeMs":0.0197},
    {"pattern":"abcabc","textLength":60,"matches":[0,3,6,9,12,15,18,21,24,27,30,33,36,39,42,45,48,51,54],"timeMs":0.0312},
    {"pattern":"longpattern","textLength":200,"matches":[i for i in range(0,200,10)],"timeMs":0.12},
    {"pattern":"verylongpattern","textLength":500,"matches":[i for i in range(0,500,10)],"timeMs":0.35}
]


text_lengths = [o['textLength'] for o in outputs]
times_ms = [o['timeMs'] for o in outputs]

plt.figure(figsize=(8,5))
plt.plot(text_lengths, times_ms, marker='o', color='blue', label='Время (ms)')
plt.title('Временная сложность KMP')
plt.xlabel('Длина текста')
plt.ylabel('Время (ms)')
plt.grid(True)
plt.legend()
plt.tight_layout()
plt.show()


space_units = [len(o['pattern']) + len(o['matches']) for o in outputs]  # оценка памяти

plt.figure(figsize=(8,5))
plt.plot(text_lengths, space_units, marker='s', color='green', label='Память (единицы)')
plt.title('Пространственная сложность KMP (условные единицы)')
plt.xlabel('Длина текста')
plt.ylabel('Память (условные единицы)')
plt.grid(True)
plt.legend()
plt.tight_layout()
plt.show()
