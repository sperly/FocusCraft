Stream.of(
Block.makeCuboidShape(0, 0, 0, 16, 4, 16),
Block.makeCuboidShape(1, 4, 4, 15, 14, 15),
Block.makeCuboidShape(7, 4, 1, 9, 7, 2),
Block.makeCuboidShape(6, 7, 1, 7, 8, 2),
Block.makeCuboidShape(9, 7, 1, 10, 8, 2),
Block.makeCuboidShape(5, 8, 1, 6, 10, 2),
Block.makeCuboidShape(10, 8, 1, 11, 10, 2)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});