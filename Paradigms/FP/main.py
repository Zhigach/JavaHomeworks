import numpy as np
import math

def mean(X):
    return sum(X) / len(X)

def std_dev(X):
    avg = mean(X)
    return math.sqrt(sum((x-avg)**2 for x in X) / len(X))

def pearson_correlation(X, Y):
    avg_X = mean(X)
    avg_Y = mean(Y)
    sd_X = std_dev(X)
    sd_Y = std_dev(Y)
    return sum((x - avg_X) * (y - avg_Y) for x, y in zip(X, Y)) / (len(X) * sd_X * sd_Y)

X = [15, 18, 21, 24, 27]
Y = [25, 25, 27, 31, 32]

print('Pearson Correlation: ', pearson_correlation(X, Y))